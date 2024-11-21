function ComponentObj() {
  const name = "홍길동";
  const student = {
    id: 0,
    name,
    score: 90,
  };
  return (
    <>
      <h2>학생id {student.id}</h2>
      <h2>학생이름{student.name}</h2>
      <h2>학생의 점수{student.score}</h2>
    </>
  );
}

export default ComponentObj;
