package mx.uv;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;

/**
 * Hello world!
 *
 */
public class AppDB
{

    public static Gson gson = new Gson();

    //public static Map<String, Usuario> usuarios = new HashMap<>();

    public static void main( String[] args )
    {   
        port(80);

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
        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        // Usuario u1 = new Usuario("1", "Pablo", "1234");
        // Usuario u2 = new Usuario("2", "Ana", "1234");

        // usuarios.put(u1.getId(), u1);
        // usuarios.put(u2.getId(), u2);

        System.out.println( "Hello World!" );
        before((req, res) -> res.type("application/Json"));
        // get("/usuario", (req, res) -> gson.toJson(u1));
        // get("/usuarios", (req, res) -> gson.toJson(usuarios));

        get("/usuarios", (req, res) -> gson.toJson(DAO.regresaUsuarios()));

        post("/", (req, res)->{
            String formulario = req.body();
            Usuario u = gson.fromJson(formulario, Usuario.class);
            //usuarios.put(u.getId(), u);
            //System.out.println("usuario agregado");
            return DAO.crearUsuario(u);
        });
    }
}
