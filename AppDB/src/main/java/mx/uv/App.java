package mx.uv;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    
    {
        port(getHerokuAssignedPort());
        get("/usuarios", (req, res) -> gson.toJson(DAO.regresaUsuarios()));

        post("/", (req, res)->{
            String formulario = req.body();
            String id = UUID.randomUUID().toString();
            Usuario u = gson.fromJson(formulario, Usuario.class);
            u.setId(id);

            JsonObject objetoJason = new JsonObject();
            objetoJson.addProperty("status", DAO.crearUsuario());
            objetoJson.addProperty("id", id);
;           return DAO.crearUsuario(u);
        });

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
