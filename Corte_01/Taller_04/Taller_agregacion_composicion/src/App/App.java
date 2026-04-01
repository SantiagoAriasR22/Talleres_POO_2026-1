package App;
import Organizador.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Oficina> oficinas = new ArrayList<>();
    public static void main(String[] args) {

        int opcion;
        do {

            System.out.println("1. Crear Oficina");
            System.out.println("2. Crear Empleado");
            System.out.println("3. Salir");
            opcion = sc.nextInt();

        }while(opcion>3 || opcion<1);
        crearobj(opcion);
    }



    public static void crearobj(int opcion){

        switch (opcion){

            case 1:
                String name;
                long id;
                int vld;
                System.out.println("Se va a crear ua oficina");
                System.out.println("Ingrese el nombre de la oficina");
                name=sc.next();
                System.out.println("Inserte el ID de la oficina");
                id=sc.nextLong();
                Oficina office = new Oficina(id, name);
                oficinas.add(office);

                System.out.println("Al haber creado una oficina, debes general al menos una tarea para que pueda ser usada");
asignarTarea(oficinas, id);

        }
    }

    public static void asignarTarea(ArrayList<Oficina> oficinas, long id){
        int opc, cont;
        long idt;
        String descripcion = "No inicializada";
        for (Oficina office : oficinas){
            if(office.getId()==id){
                if(office.getTareas().size()==0){
                    cont=0;
                }

                else{
                     cont=1;
                    System.out.println("Esta oficina ya tiene tareas asignadas, desea agregar otra?"+
                            "\n1.Si"+
                            "\n2.No");
                     opc=sc.nextInt();
                    if(opc==2){
                        return;
                    }

                }
                do {
                    System.out.println("Ingrese el ID de la tarea");
                    idt=sc.nextLong();
                    System.out.println("Escoja una de las siguientes tareas disponibles"+
                            "\n1.Implementar nuevas medidas de ciberseguridad"+
                            "\n2.Preparar informe financiero trimestral"+
                            "\n3.Lanzar campaña publicitaria en redes sociales"+
                            "\n4.Capacitación de empleados en nuevas herramientas"+
                            "\n5.Salir");
                    opc=sc.nextInt();
                    switch(opc){
                        case 1: descripcion="Implementar nuevas medidas de ciberseguridad";cont++; break;
                        case 2:  descripcion="Preparar informe financiero trimestral";cont++; break;
                        case 3: descripcion="Lanzar campaña publicitaria en redes sociales";cont++; break;
                        case 4: descripcion="Capacitación de empleados en nuevas herramientas";cont++; break;
                        case 5: if(cont==0)
                        {
                            System.out.println("No se puede crear una oficina sin tareas");
                        }
                        else{ System.out.println("Se ha creado la tarea");}
                            break;
                    }
                    if(opc<5 && opc>0){
                        office.crearTarea(idt, descripcion);
                    }


                }while(opc != 5 || cont == 0);
            }

        }


    }
}