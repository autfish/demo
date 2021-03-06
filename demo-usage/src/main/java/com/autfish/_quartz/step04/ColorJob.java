package com.autfish._quartz.step04;

import com.autfish._basic.utils.LocaleDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;

/**
 * <p>
 * This is just a simple job that receives parameters and maintains state
 * </p>
 * 
 * @author Bill Kratzer
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ColorJob implements Job {

	private static Logger _log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	// parameter names specific to this job
	public static final String FAVORITE_COLOR = "favorite color";
	public static final String EXECUTION_COUNT = "count";

	// Since Quartz will re-instantiate a class every time it
	// gets executed, members non-static member variables can
	// not be used to maintain state!
	private int _counter = 1;

	/**
	 * <p>
	 * Empty constructor for job initialization
	 * </p>
	 * <p>
	 * Quartz requires a public empty constructor so that the scheduler can
	 * instantiate the class whenever it needs.
	 * </p>
	 */
	public ColorJob() {
	}

	/**
	 * <p>
	 * Called by the <code>{@link org.quartz.Scheduler}</code> when a
	 * <code>{@link org.quartz.Trigger}</code> fires that is associated with the
	 * <code>Job</code>.
	 * </p>
	 * 
	 * @throws JobExecutionException
	 *             if there is an exception while executing the job.
	 */
	public void execute(JobExecutionContext context)
			throws JobExecutionException {

		// This job simply prints out its job name and the
		// date and time that it is running
		JobKey jobKey = context.getJobDetail().getKey();

		// Grab and print passed parameters
		JobDataMap data = context.getJobDetail().getJobDataMap();
		String favoriteColor = data.getString(FAVORITE_COLOR);
		int count = data.getInt(EXECUTION_COUNT);
		_log.info("ColorJob: " + jobKey + " executing at " + new LocaleDate()
				+ "\n" + "  favorite color is " + favoriteColor + "\n"
				+ "  execution count (from job map) is " + count + "\n"
				+ "  execution count (from job member variable) is " + _counter);

		// increment the count and store it back into the
		// job map so that job state can be properly maintained
		count++;
		data.put(EXECUTION_COUNT, count);

		// Increment the local member variable
		// This serves no real purpose since job state can not
		// be maintained via member variables!
		_counter++;
	}

}
