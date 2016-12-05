# gamehimka
#English version
Untuk versi bahasa indonesia, bisa klik di [sini](#versi-bahasa-indonesia)

This is the Android project for IAIN workshop, 4 December 2016

Android Studio version used: 2.2.2

Please make sure you have a stable internet connection to run the project. Android Studio will need to download build tool, Android SDK or maybe another dependencies from the internet.

##Common problems:

###Error 216:

The error message will be like: `Error:CreateProcess error=216, This version of %1 is not compatible with the version of Windows you're running. Check your computer's system information and then contact the software publisher`

Solution:

* Please download latest JDK8 that match with your OS here http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* Install it to your computer
* Open your project on Android Studio
* Navigate to File>Project Structure>SDK Location
* Uncheck "Use embedded JDK (recommended)"
* Fill the box below with your home JDK path that you have installed, usually in `C:\Program Files\Java\jdk1.8.x`

###Unable to start the daemon process

The error message will be like:
```
Error:Unable to start the daemon process.
This problem might be caused by incorrect configuration of the daemon.
For example, an unrecognized jvm option is used.
Please refer to the user guide chapter on the daemon at http://gradle.org/docs/1.12/userguide/gradle_daemon.html
-----------------------
Error occurred during initialization of VM
Could not reserve enough space for 1572864KB object heap
Java HotSpot(TM) Client VM warning: ignoring option MaxPermSize=256m; support was removed in 8.0
```

Solution:

* Open project structure>Android>Gradle Scripts>gradle.properties
* Locate `org.gradle.jvmargs=-Xmx1536m` and try to lower it's value, like `org.gradle.jvmargs=-Xmx256m`

If you have more problem, please create issue here or email me directly at hendraz_88@yahoo.co.id

---
#Versi Bahasa Indonesia

Ini adalah proyek Android untuk workshop IAIN, 4 Desember 2016

Versi Android Studio yang dipakai: 2.2.2

Pastikan kamu mempunyai koneksi internet yang stabil untuk menjalankan proyek ini. Android Studio akan butuh untuk mendownload build tool, Android SDK atau mungkin dependency yang lain melalui internet.

##Masalah yang mungkin terjadi:

###Error 216:

Pesan error akan seperti: `Error:CreateProcess error=216, This version of %1 is not compatible with the version of Windows you're running. Check your computer's system information and then contact the software publisher`

Solusi:

* Silakan download JDK8 versi terbaru yang sesuai dengan Sistem Operasi yang kamu pakai di http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* Install JDK tersebut ke komputer kamu
* Buka proyek ini dengan Android Studio
* Buka File>Project Structure>SDK Location
* Hapus centang "Use embedded JDK (recommended)"
* Isi box di bawahnya dengan path utama JDK yang telah kamu install, biasanya di `C:\Program Files\Java\jdk1.8.x`

###Unable to start the daemon process

Pesan error akan seperti:
```
Error:Unable to start the daemon process.
This problem might be caused by incorrect configuration of the daemon.
For example, an unrecognized jvm option is used.
Please refer to the user guide chapter on the daemon at http://gradle.org/docs/1.12/userguide/gradle_daemon.html
-----------------------
Error occurred during initialization of VM
Could not reserve enough space for 1572864KB object heap
Java HotSpot(TM) Client VM warning: ignoring option MaxPermSize=256m; support was removed in 8.0
```

Solusi:

* Buka Project structure>Android>Gradle Scripts>gradle.properties
* Temukan `org.gradle.jvmargs=-Xmx1536m` dan coba untuk mengurangi nilainya, seperti `org.gradle.jvmargs=-Xmx256m`

Kalau ada masalah lain, silakan buat issue baru di sini atau email saya secara langsung di hendraz_88@yahoo.co.id
