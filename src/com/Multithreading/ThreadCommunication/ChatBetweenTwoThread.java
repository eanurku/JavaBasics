package com.Multithreading.ThreadCommunication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatBetweenTwoThread {


    static class QAEngine{

        boolean canIAskQuestion=true;
        public void askQuestion(String question) throws InterruptedException {

                synchronized (this) {
                    while (!canIAskQuestion) {
                        this.wait();
                    }
                    System.out.println("question :"+question);
                    canIAskQuestion=false;
                    this.notifyAll();
                }

        }

        public void giveAnswers(String answer) throws InterruptedException {

            synchronized (this) {
                while (canIAskQuestion) {
                    this.wait();
                }
                System.out.println("answer :"+answer);
                canIAskQuestion=true;
                this.notifyAll();
            }
        }
    }

    static class QuestionThread extends Thread{

        List<String> questions=new ArrayList<>();
        QAEngine qaEngine;

        public QuestionThread(List<String> questions,QAEngine qaEngine){
            this.questions=questions;
            this.qaEngine=qaEngine;
        }

        public void run(){

            for(int i=0;i<questions.size();i++){
                try {
                    qaEngine.askQuestion(questions.get(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class AnswerThread extends Thread{
        List<String> answers=new ArrayList<>();
        QAEngine qaEngine;

        public AnswerThread(List<String> answers,QAEngine qaEngine){
            this.answers=answers;
            this.qaEngine=qaEngine;
        }

        public void run(){

            for(int i=0;i<answers.size();i++){
                try {
                    qaEngine.giveAnswers(answers.get(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void main(String[] args) {

        QAEngine qaEngine=new QAEngine();
        List<String> qs= Arrays.asList(new String[]{"who r u?","what ur id?","which country?"});
        List<String> ans= Arrays.asList(new String[]{"i m monu","XXXX123","india"});
        new QuestionThread(qs,qaEngine).start();
        new AnswerThread(ans,qaEngine).start();


    }
}
