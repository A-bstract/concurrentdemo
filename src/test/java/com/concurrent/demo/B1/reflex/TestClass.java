package com.concurrent.demo.B1.reflex;


public class TestClass {

    private String name;

    private String sex;

    private ClassInfo classInfo;

    static class ClassInfo {

        private String classNo;

        private String studentNum;

        private TeacherInfo teacherInfo;

        static class TeacherInfo{

            private String tName;

            private String tAge;

            public String gettName() {
                return tName;
            }

            public void settName(String tName) {
                this.tName = tName;
            }

            public String gettAge() {
                return tAge;
            }

            public void settAge(String tAge) {
                this.tAge = tAge;
            }
        }

        public String getClassNo() {
            return classNo;
        }

        public void setClassNo(String classNo) {
            this.classNo = classNo;
        }

        public String getStudentNum() {
            return studentNum;
        }

        public void setStudentNum(String studentNum) {
            this.studentNum = studentNum;
        }

        public TeacherInfo getTeacherInfo() {
            return teacherInfo;
        }

        public void setTeacherInfo(TeacherInfo teacherInfo) {
            this.teacherInfo = teacherInfo;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }
}
