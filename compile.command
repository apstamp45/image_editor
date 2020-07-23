cd "$(dirname "$0")/src/image_editor"
javac *.java
mv *.class ../../bin/image_editor
osascript -e 'tell application "Terminal" to quit'