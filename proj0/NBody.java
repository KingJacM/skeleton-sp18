public class NBody {
    public static double readRadius(String file){
        In in = new In(file);

        int firstItemInFile = in.readInt();
        double radius = in.readDouble();

        return radius;
    }

    public static Planet[] readPlanets(String file){
        double xPos;
        double yPos;
        double xVel;
        double yVel;
        double mass;
        String name;

        In in = new In(file);
        int numOfPlanet = in.readInt();
        double radius = in.readDouble();
        Planet[] planetArray = new Planet[numOfPlanet];
        int i = 0;
        while(i<numOfPlanet){
            xPos = in.readDouble();
            yPos = in.readDouble();
            xVel = in.readDouble();
            yVel= in.readDouble();
            mass = in.readDouble();
            name = in.readString();
            planetArray[i] = new Planet(xPos,yPos,xVel,yVel,mass,name);
            i+=1;
        }

        return planetArray;
    }

    public static void main(String args[]){
        Double T = Double.parseDouble(args[0]);
        Double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] Planets = readPlanets(filename);
        int numOfPlanets = Planets.length;
        double radius = readRadius(filename);

        /**
         * Start to draw
         */
        StdDraw.setXscale(-radius,radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.picture(0,0, "images/starfield.jpg");


        StdDraw.enableDoubleBuffering();
        int time = 0;
        while(time != T){
            double[] xForces = new double[numOfPlanets];
            double[] yForces =new double[numOfPlanets];
            for(int i = 0; i<numOfPlanets;i+=1){
                //For this one planet, calculate the net force by other planets in the list
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
            }

            // Update the positions and velocities of each planet, note this was copied
            for (int i = 0; i < numOfPlanets; i++) {
                Planets[i].update(dt, xForces[i], yForces[i]);
            }

            for(Planet p: Planets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

            time+=dt;
        }







    }
}
