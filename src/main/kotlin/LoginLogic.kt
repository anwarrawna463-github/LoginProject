val database:MutableMap<String,String> = mutableMapOf("anwarrawna463@gmail.com" to "12345")
fun main(){
    println("""<1> Login
        |<2> SignUp
    """.trimMargin())
    val option= readLine()?.toInt()
    if (option==2){
        while (true) {
            val email = getUserName()
            if (!isValidEmail(email)) {
                println("Not a valid email")
                continue
            }
            if (isUserExist(email)) {
                println("Username exist already")
                continue
            }
            val password = getPassword()
            addToDatabase(email, password)
            println("sign up was successful")
            break
        }
    }else {

        while (true) {
            val email = getUserName()
            if (!isValidEmail(email)) {
                println("Not a valid email")
                continue
            }
            if (!isUserExist(email)) {
                println("User does not exist")
                continue
            }
            val password = getPassword()
            if (checkPassword(email, password)) break;
        }
    }
}
fun addToDatabase(email:String,password: String){
    database[email] = password
}
fun getUserName():String{
    print("Enter the Email:")
    return readLine().toString()
}
fun getPassword():String{
    print("Enter the password:")
    return readLine().toString()
}
fun isUserExist(email:String):Boolean{
    return database.containsKey(email)
}
fun isValidEmail(email:String):Boolean{
    return Regex("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+").matches(email)
}
fun checkPassword(email:String,password:String):Boolean{
    return database[email].equals(password)
}


