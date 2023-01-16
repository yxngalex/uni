using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_DZ13
{
    internal class University : IEnumerable<Course>
    {
        public string Name { get; set; }
        private IList<Course> CourseList  { get; set; }

        public University(string Name)
        {
            this.Name = Name;
            this.CourseList = CourseList;
        }

        public void AddCourse(Course course)
        {
            CourseList.Add(course);
        }

        public IEnumerator<Course> GetEnumerator()
        {
            foreach(Course course in CourseList)
            {
                yield return course;
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }   
    }
}
