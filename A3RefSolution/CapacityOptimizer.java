public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {

		int lotSize = 0;

		double average = -1d;

		do {
			lotSize++;

			double sum = 0;

			System.out.println();
			System.out.println("==== Setting lot capacity to: " + lotSize + "====");

			for (int i = 0; i < NUM_RUNS; i++) {

				ParkingLot lot = new ParkingLot(lotSize);

				Simulator sim = new Simulator(lot, hourlyRate, Simulator.SIMULATION_DURATION);

				long start, end;

				start = System.currentTimeMillis();
				sim.simulate();
				end = System.currentTimeMillis();

				System.out.println("Simulation run " + (i + 1) + " (" + (end - start)
						+ "ms); Queue length at the end of simulation run: " + sim.getIncomingQueueSize());

				sum += sim.getIncomingQueueSize();
			}

			average = ((double) sum) / NUM_RUNS;

		} while (average > THRESHOLD);

		return lotSize;
	}

	public static void main(String args[]) throws Exception {
	
		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}