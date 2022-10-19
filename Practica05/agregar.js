function leer() {
    return todo = document.getElementById("todo").value
}

function agregar(){
    nodo=document.createElement("li")
    //texto = document.createTextNode(document.getElementById("todo").value)

    texto = document.createTextNode(leer())
    console.log(texto)
    nodo.appendChild(texto)
    document.getElementById("lista").appendChild(nodo)

}


function buscar(){

    //listaTodo = document.getElementsByTagName("li")
    const listaTodo = document.getElementsByTagName("li")

    /*for (let index = 0; index < listaTodo.length; index++) {
        const element = listaTodo[index];
        dato = listaTodo.item
        console.log(dato);
    }*/

    /*
    for (let index = 0; index < listaTodo.length; index++) {
        var arr = [].slice.call(listaTodo)
        arr.forEach(element => { 
           
           if (arr == element) {
            console.log("no se encuentra");
           }else
                console.log("se encuentra");
        });
        
    }*/

    /*for (let index = 0; index < listaTodo.length; index++) {
        const tarea = listaTodo[index];
        console.log(tarea);
        if(leer() == tarea.textContent){
                console.log("existe");
            }
    }*/
    

    /*if (document.getElementById((leer())) == null) {
        console.log("exite");
    }else 
    console.log("no existe");*/

    for (const tarea in listaTodo) {
        if (Object.hasOwnProperty.call(listaTodo, tarea)) {
            //const tarea = listaTodo[tarea];
            //if (leer() == tarea.childNodes[0]) {
                //console.log(listaTodo[tarea]);

                a = listaTodo[tarea].childNodes[0]
                b = leer()

                console.log("a ", typeof a.textContent, "b", typeof b )

                if (a == b)
                console.log("ya existe");
                    
                
                    //if (leer() == listaTodo[tarea].childNodes[0]) {
                    //    console.log("existe");
                    //} else 
                    //    console.log("no existe");
                    //    console.log(listaTodo);
                    
            //}
            
        }
    }
}