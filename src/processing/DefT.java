package processing;

import org.apache.log4j.Logger;

import java.io.Serializable;

public class DefT implements Serializable  {
    final static Logger logger = Logger.getLogger(DefT.class);
    int mark;
    public DefT(){}

    public void setMark(int mark) {
        logger.info("Setting default tab...");
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }
}
