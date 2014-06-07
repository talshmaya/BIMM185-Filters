import org.cytoscape.app.swing.AbstractCySwingApp;
import org.cytoscape.app.swing.CySwingAppAdapter;

public class MaizeApp extends AbstractCySwingApp 
{
	public MaizeApp(CySwingAppAdapter adapter)
	{
		super(adapter);
		adapter.getCySwingApplication()
                    .addAction(new HideNoData(adapter));
        adapter.getCySwingApplication()
                    .addAction(new FiltersGenes(adapter));
        adapter.getCySwingApplication()
                    .addAction(new FiltersEnzymes(adapter));
        adapter.getCySwingApplication()
                    .addAction(new FiltersMetabolites(adapter));
        adapter.getCySwingApplication()
                    .addAction(new FiltersPhospho(adapter));
	}
}
