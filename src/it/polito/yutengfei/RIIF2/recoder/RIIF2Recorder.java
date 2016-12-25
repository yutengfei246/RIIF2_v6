package it.polito.yutengfei.RIIF2.recoder;

import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Constant;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Label;
import it.polito.yutengfei.RIIF2.RIIF2Modules.parts.Parameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RIIF2Recorder implements Recorder{

    private Map<String,RIIF2Recorder> tempRecorderMap = new HashMap<>();
    private Map<String,RIIF2Recorder> componentRecorderMap = new HashMap<>();

    private String identifier = null;
    private Boolean template = null;

    private List<String> eXIdentifiers = null ;
    private List<String> implIdentifiers = null;

    private List<Parameter> parameters = null;
    private List<Constant> constants = null;

    private RIIF2Recorder flash() {
        RIIF2Recorder retRecord = new RIIF2Recorder();

        retRecord.record(this);

        return retRecord;
    }

    private void record(RIIF2Recorder recorder) {
        this.tempRecorderMap.putAll( recorder.getTempRecorderMap() );
        this.componentRecorderMap.putAll( recorder.getComponentRecorderMap() );

        if (recorder.isTemplate())
            this.tempRecorderMap.put( recorder.getIdentifier(), recorder);
        else
            this.componentRecorderMap.put( recorder.getIdentifier(), recorder);
    }

    public void setIdentifier( String identifier ) {
        this.identifier = identifier;
    }
    public String getIdentifier() {
        return identifier;
    }

    public boolean containsComponent(String exId) {
        return this.componentRecorderMap.containsKey(exId);
    }

    public boolean containsTemplate(String implId){
        return this.tempRecorderMap.containsKey(implId);
    }

    public Map<String,RIIF2Recorder> getTempRecorderMap() {
        return tempRecorderMap;
    }

    public Map<String,RIIF2Recorder> getComponentRecorderMap() {
        return componentRecorderMap;
    }

    public boolean isTemplate() {
        return template;
    }

    public void seteXIdentifiers(List<String> eXIdentifiers) {
        this.eXIdentifiers = eXIdentifiers;
    }

    public void setImplIdentifiers(List<String> implIdentifiers) {
        this.implIdentifiers = implIdentifiers;
    }

    public void addConstant(Label<Object> fieldLabel) {
        if (this.constants == null)
            this.constants = new ArrayList<>();
        this.constants.add((Constant) fieldLabel);
    }

    public void addParameter(Label<Object> fieldLabel) {
        if( this.parameters == null)
            this.parameters = new ArrayList<>();

        this.parameters.add((Parameter) fieldLabel);
    }

    public void print(int level){
            System.out.println("Record level " + level);
        if ( this.getIdentifier() != null) {
            for (int i = 0; i < level; i++)
                System.out.print("-");
            System.out.println("The Identifier of the Record is + " + this.getIdentifier());

            for (int i = 0; i < level; i++)
                System.out.print("-");
            if (this.template != null && this.template)
                System.out.println("The Record is TEMPLATE.");
            else
                System.out.println("The Record is COMPONENT. ");

            for (int i = 0; i < level; i++)
                System.out.print("-");
            if (this.parameters != null) {
                System.out.println("The record contains parameters --->" + this.parameters.size());
                for (Parameter parameter : this.parameters) {
                    System.out.println(" Parameter :" + parameter.getName());
                }
            }

            for (int i = 0; i < level; i++)
                System.out.print("-");
            if (this.constants != null) {
                System.out.println("The record contains constants --->" + this.constants.size());
                for (Constant constant : this.constants)
                    System.out.println(" Constant :" + constant.getName());
            }
        }
        System.out.println("The record extends component --->" + this.componentRecorderMap.size());
        if (this.componentRecorderMap.size() > 0) {
            for (Map.Entry<String, RIIF2Recorder> entry : this.componentRecorderMap.entrySet()) {
                System.out.println(" The eX components are : " + entry.getKey() +
                        " The contained Record's Identifier is " + entry.getValue().getIdentifier());
                RIIF2Recorder recorder = entry.getValue();
                recorder.print(level +1 );
            }
        }
    }


    @Override
    public RIIF2Recorder getRIIF2Recorder() {
        if( this.getIdentifier() == null)
            return this;

        return this.flash();
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }
}
