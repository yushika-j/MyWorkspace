// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package com.mycompany.mavenproject1;

// /**
//  *
//  * @author Anish
//  */
// public class NewsFeedMainApplication {

//     public static void main(String[] args) throws InterruptedException {

//         NewsFeed messages = new NewsFeed();
//         PhotoPost msg1;
//         TextPost msg2;

//         Post[] myPosts = new Post[12];
//         NewsFeed newsFeed1 = new NewsFeed();
//         NewsFeed newsFeed2 = new NewsFeed();

//         for (int i = 0; i < 10; i++) {
//             Thread.sleep(400);

//             if (i > 4) {
//                 myPosts[i] = new PhotoPost("Student" + i, "photo" + i + ".png", "My day #" + i);
//                 newsFeed1.add(myPosts[i]);
//             } else {
//                 myPosts[i] = new TextPost("Student" + i, "My favourite number is " + i);
//             }

//             if (i % 3 == 0) {
//                 messages.add(myPosts[i]);
//             }
//         }

//         for (int i = 4; i >= 0; i--) {
//             newsFeed2.add(myPosts[i]);
//         }

//         for (int i = 0; i < 50; i++) {
//             myPosts[0].like();
//             myPosts[9].like();
//             myPosts[9].like();
//         }
//         myPosts[0].like();
//         myPosts[9].like();

//         System.out.println();
//         System.out.println("NewsFeed #1 ");

//         for (int i = 0; i < newsFeed1.size(); i++) {
//             if (newsFeed1.get(i).isPopular()) {
//                 System.out.print("POPULAR : ");
//             }
//             System.out.println(newsFeed1.get(i));
//         }

//         System.out.println();
//         System.out.println("NewsFeed #2 ");

//         for (int i = 0; i < newsFeed2.size(); i++) {
//             if (newsFeed2.get(i).isPopular()) {
//                 System.out.print("POPULAR : ");
//             }
//             System.out.println(newsFeed2.get(i));
//         }

//         NewsFeed newsFeed3 = newsFeed1.plus(newsFeed2);

//         System.out.println();
//         System.out.println("NewsFeed #3 = NewsFeed #1 + NewsFeed #2  (sorted) ");

//         for (int i = 0; i < newsFeed3.size(); i++) {
//             System.out.println(newsFeed3.get(i));
//         }

//         newsFeed3 = newsFeed3.getPhotoPost();

//         System.out.println();
//         System.out.println("NewsFeed #3 after getPhotoPost()");

//         for (int i = 0; i < newsFeed3.size(); i++) {
//             System.out.println(newsFeed3.get(i));
//         }

//     }
// }
