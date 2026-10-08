package week_8.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Notification Channel Interface
interface NotificationChannel {

    void send(NoticeStudent student, Notice notice);
}

// Email Channel
class EmailChannel implements NotificationChannel {

    @Override
    public void send(NoticeStudent student, Notice notice) {
        System.out.println("[Email → " + student.getName() + "] "
                + notice.getTitle());
    }
}

// SMS Channel
class SmsChannel implements NotificationChannel {

    @Override
    public void send(NoticeStudent student, Notice notice) {
        System.out.println("[SMS → " + student.getName() + "] "
                + notice.getTitle());
    }
}

// App Channel
class AppChannel implements NotificationChannel {

    @Override
    public void send(NoticeStudent student, Notice notice) {
        System.out.println("[App → " + student.getName() + "] "
                + notice.getTitle());
    }
}

// Student Class for Notice System
class NoticeStudent {

    private String name;
    private String department;
    private List<NotificationChannel> channels;

    public NoticeStudent(String name, String department) {
        this.name = name;
        this.department = department;
        this.channels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    public List<NotificationChannel> getChannels() {
        return channels;
    }
}

// Notice Class
class Notice {

    private String title;
    private List<String> targetDepartments;

    public Notice(String title, List<String> targetDepartments) {
        this.title = title;
        this.targetDepartments = targetDepartments;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTargetDepartments() {
        return targetDepartments;
    }

    public boolean isValid() {
        return title != null
                && !title.trim().isEmpty()
                && targetDepartments != null
                && !targetDepartments.isEmpty();
    }
}

// Notice Board
class NoticeBoard {

    private List<NoticeStudent> students;

    public NoticeBoard(List<NoticeStudent> students) {
        this.students = students;
    }

    public void postNotice(Notice notice) {

        if (notice == null || !notice.isValid()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required."
            );
            return;
        }

        System.out.println(
                "Notice '" + notice.getTitle()
                        + "' posted to "
                        + String.join(", ", notice.getTargetDepartments())
                        + "."
        );

        for (NoticeStudent student : students) {

            if (notice.getTargetDepartments()
                    .contains(student.getDepartment())) {

                for (NotificationChannel channel : student.getChannels()) {
                    channel.send(student, notice);
                }
            }
        }

        System.out.println();
    }
}

// Main Class
public class CampusNoticeBroadcaster {

    public static void main(String[] args) {

        NoticeStudent asha =
                new NoticeStudent("Asha", "CSE");

        NoticeStudent ravi =
                new NoticeStudent("Ravi", "ECE");

        // Asha prefers Email and App
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        // Ravi prefers SMS
        ravi.addChannel(new SmsChannel());

        // Create Notice Board
        NoticeBoard noticeBoard =
                new NoticeBoard(
                        Arrays.asList(asha, ravi)
                );

        // Notice 1 - CSE
        Notice notice1 =
                new Notice(
                        "Lab Closed Tomorrow",
                        Arrays.asList("CSE")
                );

        noticeBoard.postNotice(notice1);

        // Notice 2 - CSE and ECE
        Notice notice2 =
                new Notice(
                        "Fee Deadline Extended",
                        Arrays.asList("CSE", "ECE")
                );

        noticeBoard.postNotice(notice2);

        // Notice 3 - Invalid notice
        Notice notice3 =
                new Notice(
                        "General Announcement",
                        new ArrayList<>()
                );

        noticeBoard.postNotice(notice3);
    }
}