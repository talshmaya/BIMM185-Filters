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


public class FiltersEnzymes extends AbstractCyAction {
    private final CyAppAdapter adapter;
    private javax.swing.JTextField textField;
    private javax.swing.JLabel label;

    public FiltersEnzymes(CyAppAdapter adapter) {
        super("Highlight Enzymes (Green)",
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
        textField = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        label.setText("Name");
        textField.setText("query");
        //javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        //getContentPane().setLayout(layout);

        
        
        CyColumn column = table.getColumn("cellularLocation");
        Class<?> columnType = column.getType();

        for (CyNode node : network.getNodeList()) {
            out.println(String.valueOf(network.getRow(node).get("BIOPAX_TYPE",columnType)).contains("Catalysis"));
            //String s = network.getRow(node).get("BIOPAX_TYPE",columnType);
            if (String.valueOf(network.getRow(node).get("BIOPAX_TYPE",columnType)).contains("Catalysis")){
                networkView.getNodeView(node).setVisualProperty(
                    BasicVisualLexicon.NODE_FILL_COLOR, Color.GREEN);
            }
        
        networkView.updateView();
        }
        
    }

}

