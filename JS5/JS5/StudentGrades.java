public class StudentGrades {
    Student12[] students = {
        new Student12("Ahmad", "220101001", 2022, 78, 82),
        new Student12("Budi", "220101002", 2022, 85, 88),
        new Student12("Cindy", "220101003", 2021, 90, 87),
        new Student12("Dian", "220101004", 2021, 76, 79),
        new Student12("Eko", "220101005", 2023, 92, 95),
        new Student12("Fajar", "220101006", 2020, 88, 85),
        new Student12("Gina", "220101007", 2023, 80, 83),
        new Student12("Hadi", "220101008", 2020, 82, 84)
    };

    Student12 findMax(int l, int r) {
        if (l == r) {
            return students[l];
        }
        int mid = (l + r) / 2;
        Student12 leftMax = findMax(l, mid);
        Student12 rightMax = findMax(mid + 1, r);
        return (leftMax.midtermScore >= rightMax.midtermScore) ? leftMax : rightMax;
    }

    Student12 findMin(int l, int r) {
        if (l == r) {
            return students[l];
        }
        int mid = (l + r) / 2;
        Student12 leftMin = findMin(l, mid);
        Student12 rightMin = findMin(mid + 1, r);
        return (leftMin.midtermScore <= rightMin.midtermScore) ? leftMin : rightMin;
    }

    double calculateAverage() {
        double sum = 0;
        for (Student12 s : students) {
            sum += s.finalScore;
        }
        return sum / students.length;
    }

    public static void main(String[] args) {
        StudentGrades sg = new StudentGrades();

        Student12 highestMidterm = sg.findMax(0, sg.students.length - 1);
        Student12 lowestMidterm = sg.findMin(0, sg.students.length - 1);
        double averageFinalScore = sg.calculateAverage();

        System.out.println("Highest Midterm Score (UTS): " + highestMidterm.midtermScore + " (Student: " + highestMidterm.name + ")");
        System.out.println("Lowest Midterm Score (UTS): " + lowestMidterm.midtermScore + " (Student: " + lowestMidterm.name + ")");
        System.out.println("Average Final Score (UAS): " + averageFinalScore);
    }
}