import sys
import socket
import time
import _thread
import picamera
import RPi.GPIO as GPIO
import tkinter as tk

running = False
programOpen = True

def start_server_stream(port, jpegPort):
    with picamera.PiCamera() as camera:
        camera.resolution = (640, 480)
        camera.framerate = 24

        server_socket = socket.socket()
        server_socket.bind(('0.0.0.0', int(port)))
        print("Listening to port: " + port)
        server_socket.listen(0)

        # Accept a single connection and make a file-like object out of it
        client_socket = server_socket.accept()[0]
        connection = client_socket.makefile('wb')
        running = True;
        _thread.start_new_thread(send_data, (client_socket, jpegPort))
        while programOpen:
            if(running):
                camera.start_recording(connection, format='h264')
                camera.wait_recording(30)
                camera.stop_recording()
            else:
                connection.close()
                server_socket.close()

def send_data(server_socket, jpegPort):
    sensor = 4

    GPIO.setmode(GPIO.BCM)
    GPIO.setup(sensor, GPIO.IN, GPIO.PUD_DOWN)

    previous_state = False
    current_state = False

    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    print(server_socket.getpeername()[0]);
    client_socket.connect((server_socket.getpeername()[0], int(jpegPort)))

    while programOpen:
        time.sleep(0.1)
        previous_state = current_state
        current_state = GPIO.input(sensor)
        if (current_state != previous_state):
            new_state = "HIGH" if current_state else "LOW"
            print("GPIO pin %s is %s" % (sensor, new_state))
            client_socket.send(new_state.encode() + '\n'.encode())

class main_window(tk.Frame):
    def __init__(self, master=None):
        tk.Frame.__init__(self, master)
        self.pack()
        self.create_widgets()

    def create_widgets(self):
        self.grid()

        self.port = tk.StringVar()
        self.jpegPort = tk.StringVar()


        self.ipLabel = tk.Label(self,anchor="w", text="Stream Port:")
        self.ipLabel.grid(column=0, row=0)

        self.portEntry = tk.Entry(self, textvariable=self.port)
        self.portEntry.grid(column=1,row=0,sticky='EW')

        self.portLabel = tk.Label(self,anchor="w", text="JPEG Port:")
        self.portLabel.grid(column=0, row=1)

        self.jpegEntry = tk.Entry(self, textvariable=self.jpegPort)
        self.jpegEntry.grid(column=1,row=1)

        self.connectButton = tk.Button(self, text="Start", command=self.connect)
        self.connectButton.grid(column=0, row=2)

        self.exitButton = tk.Button(self, text="Quit", command=self.close)
        self.exitButton.grid(column=1, row=2)

    def connect(self):
        try:
            _thread.start_new_thread(start_server_stream, (self.portEntry.get(),
                                                           self.jpegEntry.get()))
        except:
            print("Error Unable to start thread")

    def close(self):
        root.destroy()
        programOpen = False
        raise SystemExit


root = tk.Tk()
root.title('HomeSec Client')
app = main_window(master=root)
app.mainloop()
