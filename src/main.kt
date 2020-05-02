import kotlin.math.pow

fun main(){
    val c = Graph("c",null,null)
    val d = Graph("c",null,null)
    val b = Graph("b",null,c)
    val b1 = Graph("b1",d, b)
    val a1 = Graph("a1",null, b1)
    val a = Graph("a",a1,b)
    var x:Graph? = a
    var k = MutableList(1){0}
    var m: Int
    var n = 1
    do {
        m = k.max()!!
        k = MutableList(0){0}
        var s = ""
        for (i in 0 until 2.toDouble().pow(n).toInt()) {
            s = tenToTwo(i, n - 1)
            x = a
            k.add(0)
            for (j in s.indices)
                if (where(s[j], x!!) != null) {
                    k[i]++
                    x = where(s[j], x!!)
                } else break
            println(k[i].toString() + "   -   $s")
        }
        n++
    }while (k.max()!=m)
    print(k!!.max())


}
fun where(i:Char,a:Graph):Graph?{
    return if (i=='1')
        a.right
    else a.left
}
fun tenToTwo(a:Int,n:Int):String{
    var x = a
    var s = ""
    for (i in n downTo 0)
        if (x - 2.toDouble().pow(i) >=0){
            s += "1"
            x -= 2.toDouble().pow(i).toInt()
        }
        else s += "0"
    return s
}