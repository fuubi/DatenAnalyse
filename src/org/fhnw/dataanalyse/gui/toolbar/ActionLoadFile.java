package org.fhnw.dataanalyse.gui.toolbar;

import org.fhnw.dataanalyse.datamodell.FileChooser;
import org.fhnw.dataanalyse.datamodell.IVariableLoader;
import org.fhnw.dataanalyse.datamodell.THEVariableContainer;
import org.fhnw.dataanalyse.datamodell.VariableLoader;
import org.fhnw.dataanalyse.gui.histogram.HistoPlot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Fabrizio on 19.05.2015.
 */
public class ActionLoadFile  implements ActionListener{
    private THEVariableContainer theVariableContainer;
    private HistoPlot  histoPlot;

    public ActionLoadFile(THEVariableContainer theVariableContainer, HistoPlot histoPlot){
        this.theVariableContainer = theVariableContainer;
        this.histoPlot = histoPlot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //theVariableContainer.setVariableList(new VariableLoader(new FileChooser().getNewFile()).loadVariables());
        File file = new FileChooser().getNewFile();
        IVariableLoader loader = new VariableLoader(file).loadVariables();
        theVariableContainer =  loader.loadVariable(file);


        histoPlot.updateHistoData(theVariableContainer.getVariableList());

    }
}
