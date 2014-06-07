//package home.tal.Desktop.BIMM185.textField;
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
import java.awt.Color;
import static java.lang.System.out;
import java.awt.Container;
import org.cytoscape.util.swing.BasicCollapsiblePanel;


public class FiltersPhospho extends AbstractCyAction {
    private final CyAppAdapter adapter;
    private javax.swing.JTextField textField;
    private javax.swing.JLabel label;

    public FiltersPhospho(CyAppAdapter adapter) {
        super("Highlight Phosporylated nodes (Pink)",
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

        
        CyColumn column = table.getColumn("standardName");
        Class<?> columnType = column.getType();

        for (CyNode node : network.getNodeList()) {
            //out.println(String.valueOf(network.getRow(node).get("BIOPAX_TYPE",columnType)).contains("Protein"));
            //String s = network.getRow(node).get("BIOPAX_TYPE",columnType);
            if (String.valueOf(network.getRow(node).get("standardName",columnType)).contains("phosph") || 
                String.valueOf(network.getRow(node).get("standardName",columnType)).contains("ATP")){
                networkView.getNodeView(node).setVisualProperty(
                    BasicVisualLexicon.NODE_FILL_COLOR, Color.PINK);
            }
        
        networkView.updateView();
        }
        
    }

}

