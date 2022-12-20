<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Blog Post Form</title>
        <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <%@include file="../main/nav.jsp"%> <!-- 컴파일 시점에 포함-->
        <!-- Page Header-->
        <header class="masthead" style="background-image: url('../assets/img/c-bg.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="page-heading">
                            <h1>Post Blog</h1>
                            <span class="subheading">정보를 입력해 주세요</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Main Content-->
        <main class="mb-4">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <p>Input title and Content</p>
                        <div class="my-5">
                            <!-- * * * * * * * * * * * * * * *-->
                            <!-- * * SB Forms Contact Form * *-->
                            <!-- * * * * * * * * * * * * * * *-->
                            <!-- This form is pre-integrated with SB Forms.-->
                            <!-- To make this form functional, sign up at-->
                            <!-- https://startbootstrap.com/solution/contact-forms-->
                            <!-- to get an API token!-->
                            <form action="../blogs/post.do" method="post" id="contactForm" >
                                <!-- 컨트롤러에 있는 members-create 로 날라감 날아가서 get, post에 따라 작업 수행 -->
                                <div class="form-floating">
                                    <input class="form-control" name="title" id="title" type="text" placeholder="Enter your name..." data-sb-validations="" />
                                    <label for="name">Title</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
                                </div>

                                <div class="form-floating">
                                    <input class="form-control" name="content" id="message" type="text" placeholder="Enter your name..." data-sb-validations="" />
                                    <label for="name">Content</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
                                </div>

                                <div class="form-floating">
                                    <input class="form-control" name="regdate" type="date" id="date" max="2100-12-30" min="2000-01-01"   placeholder="Enter your name..." data-sb-validations="" />
                                    <label for="name">날짜를 입력하세요</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">A date is required.</div>
                                </div>

                                <div class="form-floating">
                                    <input class="form-control" name="author"  value="${member.name}" readonly id="name" type="text" placeholder="Enter your name..." data-sb-validations="" />
                                    <label for="name">Author</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
                                </div>
                                <div class="form-floating">
                                    <input class="form-control" name="email" value="${member.email}" readonly
                                           id="email" type="email" placeholder="Enter your email..." data-sb-validations="required,email" />
                                    <label for="email">Email address</label>
                                    <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                    <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                                </div>





                                <br />
                                <!-- Submit success message-->
                                <!---->
                                <!-- This is what your users will see when the form-->
                                <!-- has successfully submitted-->
                                <div class="d-none" id="submitSuccessMessage">
                                    <div class="text-center mb-3">
                                        <div class="fw-bolder">Form submission successful!</div>
                                        To activate this form, sign up at
                                        <br />
                                        <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                                    </div>
                                </div>
                                <!-- Submit error message-->
                                <!---->
                                <!-- This is what your users will see when there is-->
                                <!-- an error submitting the form-->
                                <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                                <!-- Submit Button-->

                                <!--<button class="btn btn-primary text-uppercase disabled" id="submitButton" type="submit">Send</button>-->
                                <input class="btn btn-primary text-uppercase" id="submitButton" type="submit" value="Post">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!-- Footer-->
        <%@include file="../main/footer.jsp"%> <!-- 컴파일 시점에 포함-->
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
