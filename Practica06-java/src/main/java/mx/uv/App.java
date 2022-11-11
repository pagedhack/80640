package mx.uv;
import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");
        options("/*", (request, response) -> {
                String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
                if (accessControlRequestHeaders != null) {
                    response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
                }
                String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
                if (accessControlRequestMethod != null) {
                    response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
                }
                return "OK";
            });
            before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
          

        System.out.println( "Hello World!" );

        get("/hello", (req, res) -> "Hello World");
        get("/Eduardo", (req, res) -> "Hello Eduardo");
        get("/Alex", (req, res) -> "Hello Alex");
        get("/Brandon", (req, res) -> "Hello Brandon");

        get("/", (req, res) -> "<h1>Bienvenido</h1> <img src = 'https://www.uv.mx/v2/images/logouv.jpg'>");


        //dato con json
        post("/", (req, res) -> {
            //System.out.println(req.queryParams("email") + " " + 
            //    req.queryParams("password"));
            //System.out.println(req.body());

            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticionCliente = arbol.getAsJsonObject();
            System.out.print(peticionCliente.get("email").getAsString() + "\n");
            System.out.print(peticionCliente.get("pass").getAsString() + "\n");

            res.status(200);// Codigo de respuesta
            JsonObject oRespuesta = new JsonObject();
            oRespuesta.addProperty("msj", "Hola");
            //oRespuesta.addProperty("email", req.queryParams("email"));
            oRespuesta.addProperty("email", peticionCliente.get("email").getAsString());
            return oRespuesta;
        });

        post("/", (req, res) -> {
            System.out.println(req.queryParams("email") + " " + 
                req.queryParams("password"));
            System.out.println(req.body());
            res.status(200);// Codigo de respuesta
            JsonObject oRespuesta = new JsonObject();
            oRespuesta.addProperty("msj", "Hola");
            oRespuesta.addProperty("email", req.queryParams("email"));
            oRespuesta.addProperty("email", req.queryParams("email"));
            return oRespuesta;
        });
    }
}
