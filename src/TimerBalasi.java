
public class TimerBalasi {
		long start, stop;

		public void start() {
			
			 start = System.currentTimeMillis();
			 
		}

		public void stop() {
			
			 stop= System.currentTimeMillis();
			 
		}

		public long getDuration() { 
			
			return (stop - start); //in milliseconds
		}
		
}
