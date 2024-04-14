package practicing;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + " : " + noOfStudents + " : " + reviewScore;
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 12000),
                new Course("API", "Microservices", 97, 2000),
                new Course("Microservices", "Microservices", 96, 22000),
                new Course("FullStack", "FullStack", 91, 18000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        //allMatch, noneMatch, anyMatch
        Predicate<Course> course95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> course90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> courseLess90Predicate = course -> course.getReviewScore() < 90;

//        System.out.println(courses.stream().allMatch(course90Predicate));
//        System.out.println(courses.stream().noneMatch(course95Predicate));
//        System.out.println(courses.stream().noneMatch(courseLess90Predicate));
//        System.out.println(courses.stream().anyMatch(courseLess90Predicate));
//        System.out.println(courses.stream().anyMatch(course95Predicate));

        Comparator comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
//        System.out.println(
//				courses.stream().
//						sorted(comparingByNoOfStudentsIncreasing).
//						collect(Collectors.toList()));

        Comparator comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
//        System.out.println(
//				courses.stream().
//					sorted(comparingByNoOfStudentsDecreasing).
//					collect(Collectors.toList()));

        Comparator comparingByNoOfStudentsAndReviews =
                Comparator
                        .comparing(Course::getNoOfStudents)
                        .thenComparing(Course::getReviewScore)
                        .reversed();
//        System.out.println(
//                courses.stream().
//                        sorted(comparingByNoOfStudentsAndReviews).
//                        collect(Collectors.toList()));
//
//        System.out.println(
//                courses.stream().
//                        sorted(comparingByNoOfStudentsAndReviews).
//						skip(3).
//						limit(5).
//                        collect(Collectors.toList()));

//		System.out.println(
//				courses.stream()
//						.takeWhile(course -> course.getReviewScore() >= 95)
//						.collect(Collectors.toList())
//		);
//
//		System.out.println(
//				courses.stream()
//						.dropWhile(course -> course.getReviewScore() >= 95)
//						.collect(Collectors.toList())
//		);

//		System.out.println(
//				courses.stream()
//						.max(comparingByNoOfStudentsAndReviews)
//		);
//
//		System.out.println(
//				courses.stream()
//						.max(comparingByNoOfStudentsAndReviews)
//		);
//
//		System.out.println(
//				courses.stream()
//						.filter(courseLess90Predicate)
//						.min(comparingByNoOfStudentsAndReviews)
//						.orElse(new Course("Kubernetes", "Cloud", 91, 220000))
//		);

//		System.out.println(
//				courses.stream()
//						.filter(courseLess90Predicate)
//						.findFirst()
//		);

//		System.out.println(
//				courses.stream()
//						.filter(course95Predicate)
//						.findFirst()
//		);
//
//		System.out.println(
//				courses.stream()
//						.filter(course95Predicate)
//						.findAny()
//		);

//		System.out.println(
//				courses.stream()
//						.filter(course95Predicate)
//						.mapToInt(Course::getNoOfStudents)
//						.sum()
//		);
//
//		System.out.println(
//				courses.stream()
//						.filter(course95Predicate)
//						.mapToInt(Course::getNoOfStudents)
//						.average()
//		);
//
//		System.out.println(
//				courses.stream()
//						.filter(course95Predicate)
//						.mapToInt(Course::getNoOfStudents)
//						.count()
//		);

		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy((Course::getCategory)))
		);

		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
		);

		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory,
								Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
		);

		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory,
								Collectors.mapping(Course::getName, Collectors.toSet())))
		);


    }
}
