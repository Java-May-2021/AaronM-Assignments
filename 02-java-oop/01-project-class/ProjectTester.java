import java.util.ArrayList;
class ProjectTester {
    public static void main(String[] args){
        Project art = new Project();
        art.project("Art Project");
        art.setDescription("Purchase art for the museum.");
        art.setInitialCost(15000.50);
        String printArt = art.elevatorPitch();
        System.out.println(printArt);

        Project movie = new Project();
        movie.project("Film Project");
        movie.setDescription("Film movie for theaters.");
        movie.setInitialCost(1854321.22);
        String printMovie = movie.elevatorPitch();
        System.out.println(printMovie);

        Project hospital = new Project();
        hospital.project("Hospital Project", "Build a Hospital for needy.");
        hospital.setInitialCost(150000000.00);
        String printHospital = hospital.elevatorPitch();
        System.out.println(printHospital);






    }
}