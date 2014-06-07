//package home.tal.Desktop.BIMM185.other_code;
import java.awt.event.ActionEvent;

import org.cytoscape.app.CyAppAdapter;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTable; 
import org.cytoscape.model.CyColumn;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;


public class HideNoData extends AbstractCyAction {
    private final CyAppAdapter adapter;

    public HideNoData(CyAppAdapter adapter) {
        super("Show nodes with data",
            adapter.getCyApplicationManager(),
            "network",
            adapter.getCyNetworkViewManager());
        this.adapter = adapter;
        setPreferredMenu("Apps.Maize App.Filters");
    }
 
    public void actionPerformed(ActionEvent e) {
        final CyApplicationManager manager = adapter.getCyApplicationManager();
        final CyNetworkView networkView = manager.getCurrentNetworkView();
        final CyNetwork network = networkView.getModel();
        final CyTable table= network.getDefaultNodeTable();

        String colToSearch = "entityReference";
        //colToSearch is a string that hold the name of the column you
        //would want to filter the nodes by (nodes that don't have attribute for that col will be hidden)

        CyColumn column = table.getColumn(colToSearch);
        Class<?> columnType = column.getType();

        for (CyNode node : network.getNodeList()) {
            if (network.getRow(node).isSet(colToSearch)==false && 
                !(String.valueOf(network.getRow(node).get("BIOPAX_TYPE",columnType)).contains("BiochemicalReaction")) ){
                networkView.getNodeView(node).setVisualProperty(
                    BasicVisualLexicon.NODE_VISIBLE, false);
            }
        
        networkView.updateView();
        }
    }

}