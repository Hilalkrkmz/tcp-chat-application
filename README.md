# TCP Chat Application (Java)

## 📌 Proje Hakkında

Bu proje, Java Socket programlama kullanılarak geliştirilmiş çok kullanıcılı bir sohbet uygulamasıdır.
Server-client mimarisi ile çalışır ve aynı anda birden fazla kullanıcıyı destekler.

---

##  Özellikler

*  Çoklu kullanıcı desteği (Thread yapısı)
*  Genel mesajlaşma
*  Özel mesajlaşma (`@kullanıcıAdı`)
*  Online kullanıcı listesi
*  Dosya gönderme ve indirme
*  Çıkış sistemi
*  Log sistemi (log.txt)

---

##  Kullanılan Teknolojiler

* Java
* TCP Socket Programming
* Java Swing (GUI)
* Multi-threading

---

##  Nasıl Çalıştırılır?

### 1️ Server başlat

```
Server.java çalıştırılır
```

### 2️ Client başlat

```
ChatGUI.java çalıştırılır
```

### 3️ Kullanıcı adı gir

```
Bağlantı kurulur ve sohbet başlar
```

---

## 📁 Proje Yapısı

```
ChatApp/
 ├── ChatServer/
 ├── ChatClient/
 ├── README.md
 └── .gitignore
```

---

##  Özellik Açıklamaları

* Kullanıcılar aynı anda bağlanabilir
* Mesajlar tüm kullanıcılara iletilir
* `@kullanıcıAdı mesaj` → özel mesaj gönderir
* Dosya gönderildiğinde diğer kullanıcıya otomatik indirilir

---

##  Not

Bu proje eğitim amaçlı geliştirilmiştir ve temel TCP iletişimi, thread yönetimi ve GUI kullanımını göstermektedir.

---
