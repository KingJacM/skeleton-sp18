public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double distanceSquared = Math.sqrt(dx*dx + dy*dy);
        return distanceSquared;

    }

    /** This method was copied to save time*/
    public double calcForceExertedBy(Planet p){
        double distance = this.calcDistance(p);
        double force = (this.G * this.mass * p.mass)/(distance*distance);
        return force;
    }

    /** This method was copied to save time*/
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        return calcForceExertedBy(p) * dx / r;
    }

    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        return calcForceExertedBy(p) * dy / r;
    }

    public double calcNetForceExertedByX (Planet[] PArray) {
        double netForce = 0;
        for(Planet p: PArray){
            if(this.equals(p)){
                continue;
            }
            netForce += calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
        }
        return netForce;
    }
    public double calcNetForceExertedByY (Planet[] PArray) {
        double netForce = 0;
        for(Planet p: PArray){
            if(this.equals(p)){
                continue;
            }
            netForce += calcForceExertedBy(p) * (p.yyPos - this.yyPos ) / this.calcDistance(p);
        }
        return netForce;
    }

    /** Note that update() was copied to save time*/
    public void update(double dt,double fX,double fY){
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }

}
