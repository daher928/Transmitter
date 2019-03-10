import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Transmitter {
	
	static String fileName = "MW_samples_original_0001613_20181114_1754.txt";
	static String SOH = String.valueOf((char)1);
	//GIT TEST GIT TEST
	public static DataSample parseLine(String fullLine) {
		String line = ((String[])fullLine.split(" "))[1];
		String[] lineSamples = line.split(SOH);
		int samplesCount = lineSamples.length;
		int timeStamp;
		DataSample dataSample = new DataSample();
		
		for (int i=0; i<samplesCount; i++) {
			String seq = lineSamples[i];
			if(i==0) {
				String ts = seq.substring(0, 6);
				String sc = seq.substring(6,8);
				timeStamp = Integer.parseInt(ts, 16);
				if(samplesCount != Integer.parseInt(sc, 16)) {
					return null;
				}
				dataSample.timeStamp = timeStamp;
				dataSample.samplesCount = samplesCount;
				String sid = seq.substring(9, 13);
				String val = seq.substring(13);
				dataSample.addData(sid, val);
			}else {
				String sid = seq.substring(1, 5);
				String val = seq.substring(6);
				dataSample.addData(sid, val);
			}
		}
		return dataSample;
	}
	
	public static void main(String[] args) {
		
		boolean startData = false;
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				if(line.equals("Start DATA")){
					startData = true;
					continue;
				}
				if(startData) {
					assert(line.contains(SOH));
					System.out.println(parseLine(line));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
