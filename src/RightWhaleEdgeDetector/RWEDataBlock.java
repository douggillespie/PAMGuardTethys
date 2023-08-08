package RightWhaleEdgeDetector;

import PamView.GroupedDataSource;
import PamView.GroupedSourceParameters;
import PamguardMVC.PamProcess;
import PamguardMVC.dataOffline.OfflineDataLoadInfo;
import PamguardMVC.dataSelector.DataSelectorCreator;
import RightWhaleEdgeDetector.datasel.RWDataSelCreator;
import RightWhaleEdgeDetector.species.RWSpeciesManager;
import pamScrollSystem.ViewLoadObserver;
import tethys.species.DataBlockSpeciesManager;
import whistlesAndMoans.AbstractWhistleDataBlock;

public class RWEDataBlock extends AbstractWhistleDataBlock<RWEDataUnit> implements GroupedDataSource {
	
	private double[] rwFreqRange = {50., 250.};
	private RWEControl rweControl;
	private RWEProcess rweProcess;
	private RWDataSelCreator dataSelCreator;
	
	private RWSpeciesManager rwSpeciesManager;

	public RWEDataBlock(RWEControl rweControl, String dataName,
			RWEProcess rweProcess, int channelMap) {
		super(RWEDataUnit.class, dataName, rweProcess, channelMap);
		this.rweControl = rweControl;
		this.rweProcess = rweProcess;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double[] getFrequencyRange() {
		return rwFreqRange;
	}

	@Override
	public boolean loadViewerData(long dataStart, long dataEnd, ViewLoadObserver loadObserver) {
		// TODO Auto-generated method stub
		return super.loadViewerData(dataStart, dataEnd, loadObserver);
	}

	@Override
	public boolean loadViewerData(OfflineDataLoadInfo offlineDataLoadInfo, ViewLoadObserver loadObserver) {
		return super.loadViewerData(offlineDataLoadInfo, loadObserver);
	}

	@Override
	public GroupedSourceParameters getGroupSourceParameters() {
		return rweControl.getGroupSourceParameters();
	}

	@Override
	public DataSelectorCreator getDataSelectCreator() {
		if (dataSelCreator == null) {
			dataSelCreator = new RWDataSelCreator(this);
		}
		return dataSelCreator;
	}

	@Override
	public DataBlockSpeciesManager<RWEDataUnit> getDatablockSpeciesManager() {
		if (rwSpeciesManager == null) {
			rwSpeciesManager = new RWSpeciesManager(this);
		}
		return rwSpeciesManager;
	}

}
