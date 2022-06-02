package pe.edu.pucp;
import pe.edu.pucp.Usuario;
import pe.edu.pucp.Actividad;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("**Bienvenidos al laboratorio 1****");

        boolean nosalir=true;
        Usuario usuario1 = null;
        while( nosalir){
            if(usuario1 == null){
                usuario1 = new Usuario();
                Scanner sc = new Scanner(System.in);
                System.out.println("usted aun no se ha registrado, ingrese sus datos personales");
                System.out.println("ingrese su nombre: ");
                usuario1.setNombre(sc.nextLine());
                System.out.println("ingrese su apellido: ");
                usuario1.setApellido(sc.nextLine());
                System.out.println("ingrese su codigo PUCP: ");
                usuario1.setCodigoPucp(Integer.parseInt(sc.nextLine()));
                System.out.println("ingrese su mail PUCP: ");
                usuario1.setEmail(sc.nextLine());
                System.out.println("ingrese su condicion(Alumno o Egresado): ");
                usuario1.setCondicion(sc.nextLine());
                // edad, es entero
                System.out.println("ingrese su edad: ");
                usuario1.setEdad(Integer.parseInt(sc.nextLine()));

                if(usuario1.getCondicion().equalsIgnoreCase("egresado")){
                    System.out.println("ingrese su sueldo:");
                    // sueldo y año de egreso son enteros
                    usuario1.setSueldo(Integer.parseInt(sc.nextLine()));
                    System.out.println("ingrese su año de egreso");
                    usuario1.setAnioEgreso(Integer.parseInt(sc.nextLine()));
                }
            }else{
                System.out.println("**Bienvenidos al laboratorio 1**** ");
                System.out.println(" ingrese su codigo pucp: ");
                Scanner sc = new Scanner(System.in);
                usuario1.setCodigoPucp(Integer.parseInt(sc.nextLine()));
                System.out.println("     \n\n\n\n         ");

                String nombreyapelldo =usuario1.getNombre() + " "+usuario1.getApellido();
                System.out.println(" Bienvenido"+ nombreyapelldo);
                System.out.println("escija una de las siguientes opciones:");

                System.out.println("opción ( 1 ).- Registrar actividad a la cual apoyaré ");
                System.out.println("opción ( 2 ).- Diagnóstico de apoyo ");
                System.out.println("opción ( 3 ).- Ver mi resumen ");
                System.out.println("opción ( 4 ).- Salir del menú ");

                Scanner escaneo = new Scanner(System.in);
                System.out.print("Ingrese opcion:");
                String opcion = escaneo.nextLine();
                //PASANDO A INT
                int opcionInt = Integer.parseInt(opcion);



                switch (opcionInt){
                    case (1):
                        System.out.println("Registre la actividad a la cual apoyará");
                        condicionwhile:
                        while(true){
                            usuario1.setActividad(new Actividad());
                            Scanner escaneo1 = new Scanner(System.in);
                            System.out.println("Ingrese el nombre de la actividad a apoyar:");

                            String actividad = escaneo1.nextLine();
                            if(actividad.equals("futsal")||actividad.equals("voley")||actividad.equals("4xjugo")||actividad.equals("glotones")||actividad.equals("basquet")){
                                usuario1.getActividad().setNombre(actividad);
                                System.out.println("ingrese su cargo:");
                                usuario1.getActividad().setCargo(escaneo1.nextLine());
                                System.out.println("ingrese sus horas de apoyo a ala fibra");
                                usuario1.getActividad().setHoras(Integer.parseInt(escaneo1.nextLine()));
                                System.out.println("ingrese su diezmo");
                                usuario1.getActividad().setDiezmo(Integer.parseInt(escaneo1.nextLine()));
                                break condicionwhile;
                            }else{
                                System.out.println("ingresar un nombre de actividad correcto");
                            }
                        }
                        break;
                    case (2):
                        if(usuario1.getCondicion().equalsIgnoreCase("egresado")){
                            int sueldo = usuario1.getSueldo();
                            int anioegreso= usuario1.getAnioEgreso();
                            int f1 = usuario1.getEdad();

                            int n= usuario1.getCodigoPucp();
                            int resu=0;
                            while(n>0){
                                resu= resu+ n%10;
                                n= n/10;
                            }
                            int factor= f1+ resu;
                            double a=sueldo*0.1;
                            int multiint= (int) Math.round(a);
                            int diezmodesead0 = ((multiint) + (2022 - anioegreso)*factor);

                            if((usuario1.getActividad().getDiezmo()) > (diezmodesead0)){
                                usuario1.getActividad().setDiezmo(diezmodesead0);
                            }
                            int diferencia= ((diezmodesead0-usuario1.getActividad().getDiezmo())/diezmodesead0)*100;
                            if(diferencia<=11){
                                System.out.println("Usted Es un hincha de nacimiento, se agradece profundamente la donación realizada a la fibra de corazón");
                            }
                            if(11<=diferencia && diferencia<=30){
                                System.out.println("Usted Es un Hincha, la fibra está con usted y usted con la fibra.");
                            }
                            if(31<=diferencia && diferencia<=50){
                                System.out.println("Usted Necesita alentar más a la fibra, pero la fibra está conforme con su apoyo actua");
                            }
                            if(51<=diferencia && diferencia<=70){
                                System.out.println("Usted Necesita encariñarse más con la fibra, sabemos que el próximo año le pondrá más apoyo.");
                            }
                            if(71<=diferencia && diferencia<=99){
                                System.out.println("Usted Es un pecho frío, pero se le agradece la colaboración");
                            }
                            if(diferencia==100){
                                System.out.println("Usted No tiene comentarios, puesto que no apoyó a la fibra.");
                            }
                        }
                        else{
                            System.out.println("Usted es un alumno, apoyó con "+ usuario1.getActividad().getDiezmo() +" soles y la fibra le agradece");
                        }
                        break;

                    case (3):
                        System.out.println("nombre completo:"+usuario1.getNombre()+ ""+usuario1.getApellido());
                        System.out.println("edad"+ usuario1.getEdad());
                        System.out.println("codigo"+usuario1.getCodigoPucp());
                        System.out.println("apoyo"+usuario1.getActividad().getNombre());


                        break;

                    case (4):
                        nosalir = false;
                        break;

                }




            }

        }

    }
}
