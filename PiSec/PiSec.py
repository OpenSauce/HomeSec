import socket
import time
import _thread
import picamera
import RPi.GPIO as GPIO

running = False
port = 5018

def start_server_stream():
    with picamera.PiCamera() as camera:
        camera.resolution = (640, 480)
        camera.framerate = 24

        server_socket = socket.socket()
        server_socket.bind(('0.0.0.0', port))
        server_socket.listen(0)

        # Accept a single connection and make a file-like object out of it
        client_socket = server_socket.accept()[0]
        connection = client_socket.makefile('wb')
        running = True;
        _thread.start_new_thread(send_data, (client_socket, ))
        while 1:
            if(running):
                camera.start_recording(connection, format='h264')
                camera.wait_recording(30)
                camera.stop_recording()
            else:
                connection.close()
                server_socket.close()

def send_data(server_socket):
    sensor = 4

    GPIO.setmode(GPIO.BCM)
    GPIO.setup(sensor, GPIO.IN, GPIO.PUD_DOWN)

    previous_state = False
    current_state = False

    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    print(server_socket.getpeername()[0]);
    client_socket.connect((server_socket.getpeername()[0], 6000))

    while True:
        time.sleep(0.1)
        previous_state = current_state
        current_state = GPIO.input(sensor)
        if (current_state != previous_state):
            new_state = "HIGH" if current_state else "LOW"
            print("GPIO pin %s is %s" % (sensor, new_state))
            client_socket.send(new_state.encode() + '\n'.encode())

try:
    _thread.start_new_thread(start_server_stream, ())
    print("Poontang!")
except:
    print("Error Unable to start thread")
