# sailor
I'm a sailor who is looking foward to the sea.
This is a project which based on the leetcode and https://programmercarl.com/.

# leetcode plugin config
```
TemplateFilePath:
/Users/huajun.wu/IdeaProjects/sailor/src/main/java/com/onepiece

Code FileName:
Q$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})

Code Template:
${question.content}
  
  package com.onepiece.leetcode.editor.en;
  public class Q$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}){
 //$!velocityTool.date()
    //${question.title}
    //编号：[$!{question.frontendQuestionId}]
      public static void main(String[] args) {
           Solution solution = new Q$!{question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
      }
      ${question.code}
  }
```