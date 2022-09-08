<<<<<<< HEAD
// regresa de forma textual los parámetros leidos con get
  const doGet = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Arnold', apellido = 'GetSchwarzenegger' , telefono = '123456789' , direccion = 'canada'} = parameter;
    const salida = `Hola ${nombre} ${apellido} ${telefono} ${direccion}`;
    return ContentService.createTextOutput(salida);
  };

// regresa de forma textual los parámetros leidos con post
  const doPost = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Arnold', apellido = 'PostSchwarzenegger' , telefono = '123456789' , direccion = 'canada'} = parameter;
    const salida = `Hola ${nombre} ${apellido} ${telefono} ${direccion}`;
    return ContentService.createTextOutput(salida);
=======
// regresa de forma textual los parámetros leidos con get
  const doGet = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Arnold', apellido = 'GetSchwarzenegger' , telefono = '123456789' , direccion = 'canada'} = parameter;
    const salida = `Hola ${nombre} ${apellido} ${telefono} ${direccion}`;
    return ContentService.createTextOutput(salida);
  };

// regresa de forma textual los parámetros leidos con post
  const doPost = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Arnold', apellido = 'PostSchwarzenegger' , telefono = '123456789' , direccion = 'canada'} = parameter;
    const salida = `Hola ${nombre} ${apellido} ${telefono} ${direccion}`;
    return ContentService.createTextOutput(salida);
>>>>>>> 739dda0 (borrador)
  };