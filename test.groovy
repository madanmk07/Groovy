node('master') {
    
git 'https://github.com/madanmk07/Hello-java.git'
bat '''cd Hello-java
javac Hello.java
java Hello'''


}
