
class WorkerThread implements Runnable {
	private String message;
	EvaluateExpresion evaluateExpresion;

	public WorkerThread(String s, EvaluateExpresion evaluateExpresion) {
		this.message = s;
		this.evaluateExpresion=evaluateExpresion;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
		try {
			//System.out.println("Evaluate Expression " +evaluateExpresion.evaluate("5+4-1*2"));
		} catch (Exception e) {
				e.printStackTrace();
		}
							// for 2 seconds
		System.out.println(Thread.currentThread().getName() + " (End)");// prints
																		// thread
																		// name
	}

	

}
