package edu.ljodi937.jsoncourseinfoconverger;
public class Course{


    String title;
    String genEdReq;
    boolean iswriting;
    boolean isDEI;
    boolean isperformance;
    boolean islanguage;

    public Course(String title1, String gened, boolean write, boolean dei, boolean perform, boolean language){
        //super(code,dep,title1);
        this.title = title1;
        this.genEdReq = gened;
        this.iswriting = write;
        this.isDEI = dei;
        this.isperformance = perform;
        this.islanguage = language;
    }
    @Override
    public String toString(){
      return this.title+"\n GenedREQ:"+this.genEdReq+"\nISWRITING?"+this.iswriting;
    }
}
