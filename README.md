#  TCP Chat Application (Java)

## 📌 About

This project is a multi-client chat application developed using Java TCP Socket programming.
It enables real-time communication between multiple users through a simple graphical interface.

---

##  Screenshot

![Chat Application](screenshott.png)

---

##  Features

* Multi-client support (Thread-based)
* Public messaging
* Private messaging (`@username`)
* Online user list
* File sending & automatic downloading
* Exit system
* Logging system (`log.txt`)

---

##  Technologies

* Java
* TCP Socket Programming
* Java Swing (GUI)
* Multithreading

---

##  How to Run

1. Run `Server.java`
2. Run `ChatGUI.java`
3. Enter a username
4. Start chatting

---

## 📁 Project Structure

```
ChatApp/
 ├── ChatServer/
 ├── ChatClient/
 ├── screenshot.png
 ├── README.md
 └── .gitignore
```

---

## 📌 Notes

* Multiple clients can connect simultaneously
* Messages are broadcast to all users
* Private messages can be sent using `@username`
* Sent files are automatically received and saved by other clients

---

##  Purpose

This project is developed for educational purposes to demonstrate TCP communication, multithreading, and GUI development in Java.
