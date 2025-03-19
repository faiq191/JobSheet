public class MemberMain {
    public static void main(String[] args) {
        Member[] members = {
                new Member("Peter", 45, 15, 120.0),
                new Member("Ben", 42, 20, 140.0),
                new Member("Nina", 35, 35, 225.0),
                new Member("Alpha", 37, 30, 200.0),
                new Member("Lisa", 39, 35, 225.0),
                new Member("Beckham", 38, 30, 240.0)
                
        };

        int totalWorkoutHoursAbove40 = 0;
        int countMembersBetween35And40 = 0;
        for (Member member : members) {
            if (member.age > 40) {
                totalWorkoutHoursAbove40 += member.workoutHours;
            } else if (member.age >= 35 && member.age < 40) {
                countMembersBetween35And40++;
            }

            if (member.workoutHours > 15) {
                double discount = member.membershipFee * 0.1;
                member.totalCost = member.membershipFee - discount;
            } else {
                member.totalCost = member.membershipFee;
            }
        }
        System.out.println("Total workout hours of members above 40 years old: " + totalWorkoutHoursAbove40);
        System.out.println("Number of members between 35 and 40 years old: " + countMembersBetween35And40);
        for (Member member : members) {
            System.out.println("Member: " + member.memberName + ", Total Cost: " + member.totalCost);
        }
    }
}

