import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

import { books, blogs, courses } from "./Data";

function App() {

    const showBooks = true;
    const showBlogs = true;
    const showCourses = true;

    let bookContent;

    if (showBooks) {
        bookContent = <BookDetails books={books} />;
    }

    return (

        <div className="container">

            <div className="column">

                {showCourses && (
                    <CourseDetails courses={courses} />
                )}

            </div>

            <div className="column">

                {bookContent}

            </div>

            <div className="column">

                {showBlogs ? (
                    <BlogDetails blogs={blogs} />
                ) : (
                    <h2>No Blogs Available</h2>
                )}

            </div>

        </div>

    );

}

export default App;