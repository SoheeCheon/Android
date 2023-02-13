package ko.cheonsohee.mykotlinbasic

// 앱의 시작점을 나타내는 함수
// 시작버튼은 main에만 달려있다.
fun main() {
    // TODO: ADD new functional
    var myName = "Sohee"
//    print("Hello " + myName)

    var height1 = 170
    var height2 = 189

//    if (height1 > height2) {
//        println("use raw force")
//    }else{
//        println("use technique")
//    }

    var season = 3

    when(season){
        1 -> println("Spring")
        2 -> println("Summer")
        3 -> {
            println("Fall")
            println("Autumn")
        }
        4 -> println("Winter")
        else -> println("Error")
    }

    var x = 1
    while(x<=10) {
        println("$x")
        x++
    }
    println("while loop is done")
}
