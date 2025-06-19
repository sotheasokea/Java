
import java.util.Scanner;

public class Classroom1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numClassroom = input.nextInt();
        input.nextLine();
        Classroom[] classrooms = new Classroom[numClassroom];
        for(int i = 0; i<numClassroom; i++){
            String className = input.next();
            int classCapacity = input.nextInt();
            boolean hasProjector = (input.nextInt() == 1);
            boolean hasVisualizer = (input.nextInt() == 1);
            boolean hasSmartBoard = (input.nextInt() == 1);
            boolean hasRecordingCamera = (input.nextInt() == 1);
            input.nextLine();
            classrooms[i] = new Classroom(className, classCapacity, hasProjector, hasVisualizer, hasSmartBoard, hasRecordingCamera);
        
        }
        int numOfReserved = input.nextInt();
        for(int i = 0; i<numOfReserved; i++){
            int wantedClassCapacity = input.nextInt();
            boolean Projector = (input.nextInt() == 1);
            boolean Visualizer = (input.nextInt() == 1);
            boolean SmartBoard = (input.nextInt() == 1);
            boolean RecordingCamera = (input.nextInt() == 1);

            boolean found = false;
            for(int k = 0; k<numClassroom; k++){
                if(classrooms[k].reserve(wantedClassCapacity, Projector, Visualizer, SmartBoard, RecordingCamera)){
                    System.out.println(classrooms[k].className);
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("classroom not available");
            }
        }

        input.close();
    }
}
class Classroom{
    String className;
    int classCapacity;
    boolean hasProjector;
    boolean hasVisualizer;
    boolean hasSmartBoard;
    boolean hasRecordingCamera;
    boolean classIsReserved;
    Classroom(String className, int classCapacity, boolean hasProjector, boolean hasVisualizer, boolean  hasSmartBoard, boolean hasRecordingCamera){
        this.className     = className;
        this.classCapacity = classCapacity;
        this.hasProjector  = hasProjector;
        this.hasVisualizer = hasVisualizer;
        this.hasSmartBoard = hasSmartBoard;
        this.hasRecordingCamera = hasRecordingCamera;
        this.classIsReserved = false;
    }
    boolean isAvailable(int wantedClassCapacity, boolean hasProjector, boolean hasVisualizer, boolean hasSmartBoard, boolean hasRecordingCamera){
        if(!classIsReserved){
            if(wantedClassCapacity <= classCapacity){
                if(hasProjector){
                    if(!this.hasProjector){
                        return false;
                    }
                }
                if(hasVisualizer){
                    if(!this.hasVisualizer){
                        return false;
                    }
                }
                if(hasSmartBoard){
                    if(!this.hasSmartBoard){
                        return  false;
                    }
                }
                if(hasRecordingCamera){
                    if(!this.hasRecordingCamera){
                        return false;
                    }
                }
                this.classIsReserved = true;
                return true;
            }
        }
        return false;
    }
    boolean reserve(int wantedClassCapacity, boolean hasProjector, boolean hasVisualizer, boolean hasSmartBoard, boolean hasRecordingCamera){
        return isAvailable(wantedClassCapacity, hasProjector, hasVisualizer, hasSmartBoard, hasRecordingCamera);
    }
}