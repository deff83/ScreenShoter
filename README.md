# ScreenShoter

This program is designed to automatically save the screen display in a specified period of time.  
When you first start the program, it asks for the path and periodicity of time to save the files. This creates a **config.xml** next to the launcher. Where you can change these values. 
This format is given in xml tags.  
```html
<?xml version="1.0" encoding="UTF-8"?>
<ConfigRes>
<Path>C:\JAVA\PROECTS\EXE</Path>
<Timer>30</Timer>
</ConfigRes> 
```
Path - The path to save screenshots.  
Timer- Interval time in seconds.  
Install this exe program anywhere on your computer, and create a startup shortcut in the startup folder (usually located on the path C:\ProgramData\Microsoft\Windows\Start Menu\Programs\StartUp).  
This program will run in the **background** and is **not visible** to the user.  
