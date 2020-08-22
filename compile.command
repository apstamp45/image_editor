cd "$(dirname "$0")/src/com/apstamp45/image_editor"
javac *.java
mv *.class ../../../../bin/com/apstamp45/image_editor
//osascript -e 'tell application "Terminal" to quit'