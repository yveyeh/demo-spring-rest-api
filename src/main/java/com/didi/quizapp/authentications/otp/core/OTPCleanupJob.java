package com.didi.quizapp.authentications.otp.core;

// import java.io.FileReader;
// import java.util.Date;
// import java.util.Properties;

// import org.quartz.Job;
// import org.quartz.JobBuilder;
// import org.quartz.JobDetail;
// import org.quartz.Scheduler;
// import org.quartz.SchedulerException;
// import org.quartz.SimpleScheduleBuilder;
// import org.quartz.Trigger;
// import org.quartz.impl.StdSchedulerFactory;

public class OTPCleanupJob {

//     private static final String CONFIG_FILE = "otp_cleanup_config.properties"; // Replace with your config file path

//     public static void main(String[] args) throws SchedulerException {
//         // Read configuration for repetition time
//         int repetitionMinutes = getRepetitionTimeFromConfig();

//         // Define the cleanup job
//         JobDetail jobDetail = JobBuilder.ofType(OTPCleanupTask.class).build();

//         // Define the trigger to run the job every repetitionMinutes minutes
//         Trigger trigger = SimpleScheduleBuilder.simpleSchedule()
//                 .withIntervalInMinutes(repetitionMinutes)
//                 .repeatForever()
//                 .build();

//         // Get a scheduler instance
//         Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

//         // Schedule the job with the defined trigger
//         scheduler.scheduleJob(jobDetail, trigger);

//         // Start the scheduler
//         scheduler.start();
//     }

//     private static int getRepetitionTimeFromConfig() {
//         Properties properties = new Properties();
//         try (FileReader reader = new FileReader(CONFIG_FILE)) {
//             properties.load(reader);
//             return Integer.parseInt(properties.getProperty("repetition_minutes"));
//         } catch (Exception e) {
//             throw new RuntimeException("Error reading configuration file: " + e.getMessage());
//         }
//     }
}

// // Class for the actual cleanup task (replace with your implementation)
// class OTPCleanupTask implements Job {

//     @Override
//     public void execute(JobExecutionContext context) throws JobExecutionException {
//         // Access your data storage (database, cache, etc.) to retrieve OTPs
//         List<OTP> otps = getOTPs(); // Replace with your logic to retrieve all OTPs

//         Date currentTime = new Date();
//         for (OTP otp : otps) {
//             if (otp.getExpiresAt().before(currentTime) || otp.getAttempts() >= otp.getNumberOfRequests() || !otp.isValid()) {
//                 // Implement logic to mark OTP as deleted or remove it permanently (based on your storage)
//                 deleteOTP(otp);
//             }
//         }
//     }
// }

// // Class representing your OTP object (replace with your actual OTP structure)
// class OTP {
//     private Date expiresAt;
//     private int attempts;
//     private boolean isValid;

//     // Getters and setters for expiresAt, attempts, isValid
//     // ...

//     // Implement deleteOTP method based on your storage mechanism
//     public void deleteOTP() {
//         // ...
//     }
// }
