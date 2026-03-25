use std::io;

fn main() {
    println!("Enter integer a:");
    let mut a = String::new();
    io::stdin()
        .read_line(&mut a)
        .expect("Failed to read line");
    let a: i32 = a.trim()
        .parse()
        .expect("Not an integer");

    println!("Enter and integer b:");
    let mut b = String::new();
    io::stdin()
        .read_line(&mut b)
        .expect("Failed to read line");
    let b: i32 = b.trim()
        .parse()
        .expect("Not an integer");

    println!("{}", euclidean(a, b));
}

fn euclidean(mut a: i32, mut b: i32) -> i32 {
    while b!= 0 {
        (a, b) = (b, a%b);
    }
    a
}
