import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

val apiKey = "nwiiwndFOLo0UQkWwjhq4A826RbLcZrh"
fun main()
{

    getHtml("https://api.nytimes.com/svc/archive/v1/2019/1.json?api-key=$apiKey")

}



fun getHtml(website: String)
{
    val url = URL(website)
    println(website)
    val http = url.openConnection()
    val reader = http.getInputStream()

    val bufferReader = BufferedReader(InputStreamReader(reader))

    var json = StringBuffer();
    for(line in bufferReader.lines())
    {
        json.append(line);

    }

    var response = articles()

    var builder = GsonBuilder()
    var gson = builder.create()


    println(gson.fromJson(json.toString(), response.javaClass))
}