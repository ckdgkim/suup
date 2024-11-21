function Form3({student, changeValue}) {
  return (
    <>
      <label htmlFor="id">id</label><input type="text" value={student.id} id="id" disabled />
      <label htmlFor="name">name</label><input type="text" value={student.name} id="name" disabled />
      <label htmlFor="score">score</label><input type="text" name="score" value={student.score} id="score" onChange={changeValue} />
      <label htmlFor="age">age</label><input type="text" name="age" id="age" onChange={changeValue} />
      <label htmlFor="school">school</label><input type="text" name="school" id="school" onChange={changeValue} />
    </>
  )
}

export default Form3;